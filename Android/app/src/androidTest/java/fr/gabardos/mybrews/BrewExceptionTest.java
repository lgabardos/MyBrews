package fr.gabardos.mybrews;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import fr.gabardos.mybrews.core.BrewException;
import fr.gabardos.mybrews.core.ErrorCodes;

import static org.junit.Assert.assertEquals;

/**
 *
 * Created by Laurent on 26/03/2018.
 */

@RunWith(AndroidJUnit4.class)
public class BrewExceptionTest {
	@Test
	public void useBrewException() throws Exception {
		// Context of the app under test.
		Context appContext = InstrumentationRegistry.getTargetContext();

		BrewException e = new BrewException(appContext, ErrorCodes.CLASS_NOT_MAPPED, "Coucou", null);
		assertEquals(e.getErrorCodes().getValue(), ErrorCodes.CLASS_NOT_MAPPED.getValue());
		assertEquals("Coucou", e.getMessage());

		e = new BrewException(appContext, ErrorCodes.CLASS_NOT_MAPPED, new Object[]{Integer.class.getSimpleName()});
		assertEquals(e.getErrorCodes().getValue(), ErrorCodes.CLASS_NOT_MAPPED.getValue());
		assertEquals("The class \"Integer\" is not mapped", e.getMessage());

		e = new BrewException(appContext, ErrorCodes.TOO_MANY_RESULT, new Object[]{Integer.class.getSimpleName(), 23});
		assertEquals(e.getErrorCodes().getValue(), ErrorCodes.TOO_MANY_RESULT.getValue());
		assertEquals("Too many result for the object \"Integer\" with id \"23\"", e.getMessage());

		e = new BrewException(appContext, ErrorCodes.OBJECT_NOT_FOUND, new Object[]{Integer.class.getSimpleName(), 23});
		assertEquals(e.getErrorCodes().getValue(), ErrorCodes.OBJECT_NOT_FOUND.getValue());
		assertEquals("\"Integer\" with id \"23\" not found", e.getMessage());
	}
}
