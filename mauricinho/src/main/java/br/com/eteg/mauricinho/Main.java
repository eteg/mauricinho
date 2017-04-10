package br.com.eteg.mauricinho;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class Main {
	public static void main(String[] args) {
		final String file = "src/main/resources/hello_word_pentaho_text.ktr";

		try {
			KettleEnvironment.init();
			
			final TransMeta metadata = new TransMeta(file);
			final Trans trans = new Trans(metadata);

			trans.execute(null);
			trans.waitUntilFinished();

			if (trans.getErrors() > 0) {
				System.err.println("Error Executing Transformation");
			}
		} catch (KettleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
