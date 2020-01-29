package org.aztec.sovn.core.ml.prolog;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import alice.tuprolog.InvalidLibraryException;
import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Term;
import alice.tuprolog.Theory;

public class InferenceEngine {
	
	public SolveInfo getSolution(File prologFile) throws MalformedGoalException, InvalidLibraryException, FileNotFoundException, IOException, InvalidTheoryException{
		Theory theory = new Theory(new FileInputStream(new File("test/test1.2p")));
		Prolog prolog = PrologFactory.getBasicProlog();
		prolog.addTheory(theory);
		SolveInfo si = prolog.solve("prog(X).");
		return si;
	}
	
	

	public static void main(String[] args) {
		
		try {
			Theory theory2 = new Theory(new FileInputStream(new File("test/test1.2p")));
			Prolog prolog = PrologFactory.getBasicProlog();
			prolog.addTheory(theory2);
			SolveInfo si = prolog.solve("prog(X).");
			Term solution = si.getSolution();
			System.out.println(solution);
			System.out.println(si.isSuccess());
			System.out.println(si);
			System.out.println(si.getVarValue("X"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
