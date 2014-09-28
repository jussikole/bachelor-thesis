package bet.result;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class ResultOddRow {
	private List<ResultOddValue> values;
	
	public ResultOddRow() {
		this.values = new ArrayList<ResultOddValue>();
	}

	@OneToMany
	public List<ResultOddValue> getValues() {
		return values;
	}
	public void setValues(List<ResultOddValue> values) {
		this.values = values;
	}
}
