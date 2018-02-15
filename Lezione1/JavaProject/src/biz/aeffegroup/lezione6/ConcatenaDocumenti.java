package biz.aeffegroup.lezione6;

import java.util.ArrayList;
import java.util.List;

public class ConcatenaDocumenti
{

	List<String> documenti;

	public ConcatenaDocumenti()
	{
	}

	public ConcatenaDocumenti(List<String> doc)
	{
		this.documenti = doc;
	}

	public void addDoc(String doc)
	{
		if (this.documenti == null)
			this.documenti = new ArrayList<>();
		this.documenti.add(doc);
	}

	private boolean validate()
	{
		Boolean ok = false;
		// TODO fare la validazione

		return ok;
	}

	public String concatenate()
	{
		if (!this.validate())
			return "";
		return "";
	}

}
