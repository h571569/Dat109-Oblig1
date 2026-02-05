package no.hvl.dat109.interfaces;

import no.hvl.dat109.Brikke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BrikkeInterfaceTest {
	  Brikke[] brikker;
	  Random r = new Random();

	  @BeforeEach
	  void lagelage() {
			this.brikker = new Brikke[10];
			for (int i = 0; i < 10; i++) {
				  brikker[i] = new Brikke(i+1, i);
			}
	  }

	  @Test
	  void testGetPosisjon() {
			for (int i = 0; i < 10; i++) {
				  assertEquals(this.brikker[i].getPosisjon(), i+1, "fyy");
			}
	  }

	  @Test
	  void testSetPosisjon() {
			for (int i = 0; i < 10; i++) {
				  int ran = this.r.nextInt(1, 100);
				  this.brikker[i].setPosisjon(ran);
				  assertEquals(this.brikker[i].getPosisjon(), ran, "hvis metoden get posiosjon feiler, kan feilen ligge der");
			}
	  }
}