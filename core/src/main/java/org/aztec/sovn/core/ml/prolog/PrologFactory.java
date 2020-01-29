package org.aztec.sovn.core.ml.prolog;

import alice.tuprolog.InvalidLibraryException;
import alice.tuprolog.Prolog;
import alice.tuprolog.lib.BasicLibrary;
import alice.tuprolog.lib.ISOLibrary;

public class PrologFactory {

	public static Prolog getBasicProlog() throws InvalidLibraryException{
		return new Prolog(new String[]{BasicLibrary.class.getName(),
				ISOLibrary.class.getName()});
	}
	
}
