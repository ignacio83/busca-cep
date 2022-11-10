package br.com.afi.web.rest.busca.cep.service;

import br.com.afi.web.rest.busca.cep.domain.Endereco;
import br.com.afi.web.rest.busca.cep.domain.InvalidCepException;
import br.com.afi.web.rest.busca.cep.repository.EnderecoRepository;
import br.com.afi.web.rest.busca.cep.service.impl.CepServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * Testes unitários para a consulta de CEP.
 *
 * @author André de Fontana Ignacio
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
public class CepServiceTest {
	private final static String CEP_INVALIDO = "01001-123";
	private final static String CEP_VALIDO = "01001123";
	private final static String CEP_VALIDO_ZEROS = "01001000";
	private final Dado dado = new Dado();
	private final Quando quando = new Quando();
	private final Entao entao = new Entao();
	private String cep;
	private Endereco endereco;

	@Mock(lenient = true)
	private EnderecoRepository enderecoRepository;

	@InjectMocks
	private CepService cepService = new CepServiceImpl();

	@BeforeEach
	public void clear() {
		cep = null;
		endereco = null;
		Mockito.reset(enderecoRepository);
	}

	/**
	 * Dado um CEP inválido deve retornar a mensagem CEP inválido.
	 *
	 * @throws InvalidCepException
	 */

	@Test
	public void testCepInvalido() {
		assertThrows(InvalidCepException.class, () -> {
			dado.umCepInvalido();
			quando.buscaPeloCep();
		});
	}

	/**
	 * Dado um CEP válido deve retornar o endereço correspondente.
	 *
	 * @throws InvalidCepException
	 */
	@Test
	public void testCepValido() throws InvalidCepException {
		dado.umCepValido().cadastrado();
		quando.buscaPeloCep();
		entao.deveRetornarOEnderecoCorrespondente();
	}

	/**
	 * Dado um CEP válido, que não exista um endereço, deve substituir um digito da direita para a esquerda até que o endereço seja localizado.
	 * Exemplo: Dado 22333999 tentar com 22333990, 2233900 ...
	 *
	 * @throws InvalidCepException
	 */
	@Test
	public void testCepValidoNaoExistente() throws InvalidCepException {
		dado.umCepValido().cadastradoComZerosADireita();
		quando.buscaPeloCep();
		entao.deveRetornarOEnderecoSimilarCorrespondente();
	}

	private class Dado {
		public Dado umCepValido() {
			cep = CEP_VALIDO;
			return this;
		}

		public Dado umCepInvalido() {
			cep = CEP_INVALIDO;
			return this;
		}

		public Dado cadastrado() throws InvalidCepException {
			final Endereco e = new Endereco(cep, "qualquer", "qualquer", "São Paulo", "SP");
			when(enderecoRepository.findById(eq(cep))).thenReturn(Optional.of(e));
			return this;
		}

		public Dado cadastradoComZerosADireita() throws InvalidCepException {
			final Endereco e = new Endereco(CEP_VALIDO_ZEROS, "qualquer", "qualquer", "São Paulo", "SP");
			when(enderecoRepository.findById(eq(CEP_VALIDO_ZEROS))).thenReturn(Optional.of(e));
			return this;
		}
	}

	private class Quando {
		public Quando buscaPeloCep() throws InvalidCepException {
			endereco = cepService.findByCep(cep);
			return this;
		}
	}

	private class Entao {
		public Entao deveRetornarOEnderecoCorrespondente() {
			assertNotNull(endereco, "CEP não encontrado");
			assertEquals(cep, endereco.getCep(), "CEP incorreto encontrado");
			return this;
		}

		public Entao deveRetornarOEnderecoSimilarCorrespondente() {
			assertNotNull(endereco, "CEP não encontrado");
			assertEquals(CEP_VALIDO_ZEROS, endereco.getCep(), "CEP incorreto encontrado");
			return this;
		}
	}
}
