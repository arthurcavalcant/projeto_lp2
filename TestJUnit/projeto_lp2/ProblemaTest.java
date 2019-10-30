package projeto_lp2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProblemaTest {

	private Problema problemaComum;

	@BeforeEach
	void testInit() {

		this.problemaComum = new Problema(
				"O problema do ainda baixo numero de profissionais mulheres atuando na area de TI", 5);

	}

	@Test
	void testProblemaComum() {

		Problema problema = new Problema("A problematica de casos de homofobia em servicos de motorista por aplicativo",
				5);
		assertEquals("A problematica de casos de homofobia em servicos de motorista por aplicativo - 5",
				problema.toString());

	}

	@Test
	void testProblemaDescricaoVazia() {

		assertThrows(IllegalArgumentException.class, () -> {
			Problema problema = new Problema("", 5);
		});

	}
	
	
	void testProblemaDescricaoNull() {

		assertThrows(NullPointerException.class, () -> {
			Problema problema = new Problema(null, 5);
		});

	}

	
	@Test
	void testProblemaViabilidadeInvalidaMenor() {

		assertThrows(IllegalArgumentException.class, () -> {
			Problema problema = new Problema("A problematica da supremacia quantica", 0);
		});

	}

	@Test
	void testProblemaViabilidadeInvalidaMaior() {

		assertThrows(IllegalArgumentException.class, () -> {
			Problema problema = new Problema("A problematica da supremacia quantica", 6);
		});

	}
	
	@Test
	void testToString() {
		
		Problema problema = new Problema("A problematica de discursos de odio destinado a minorias no Twitter", 5);
		assertEquals("A problematica de discursos de odio destinado a minorias no Twitter - 5", problema.toString());
		
	}

}