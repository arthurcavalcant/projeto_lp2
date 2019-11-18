package base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excecoes.ActivationException;

class ItemTest {
	private Item itemBase1;
	private Item itemBase2;
	
	@BeforeEach
	void criaItens() {
		itemBase1 = new Item("Calcular a energia necessária para simular as condiçoes iniciais do universo num acelerador de partículas");
		itemBase2 = new Item("Verificar se a condição sem contorno do universo é verdadeira");
	}

	@Test
	void testItemValido() {
		assertFalse(itemBase1.getStatus());
		assertFalse(itemBase2.getStatus());
	}
	
	@Test
	void testItemDescricaoNull() {
		assertThrows(NullPointerException.class, () -> {
            Item novoItem = new Item(null);
        });
	}
	
	@Test
	void testItemDescricaoVazia() {
		assertThrows(IllegalArgumentException.class, () -> {
            Item novoItem = new Item("");
        });
	}

	@Test
	void testToString() {
		assertEquals("PENDENTE - Calcular a energia necessária para simular as condiçoes iniciais do universo num acelerador de partículas", itemBase1.toString());
		assertEquals("PENDENTE - Verificar se a condição sem contorno do universo é verdadeira", itemBase2.toString());
	}

    @Test
    void realizar() {
		itemBase1.realizar(20);
		assertTrue(itemBase1.getStatus());
    }

	@Test
	void realizarItemRealizado() {
		itemBase1.realizar(15);
		assertThrows(ActivationException.class, () -> {
			itemBase1.realizar(15);
		});
	}

    @Test
    void getStatusItemRealizado() {
		itemBase1.realizar(10);
		assertTrue(itemBase1.getStatus());
    }

	@Test
	void getStatusItemNaoRealizado() {
		assertFalse(itemBase1.getStatus());
	}
}
