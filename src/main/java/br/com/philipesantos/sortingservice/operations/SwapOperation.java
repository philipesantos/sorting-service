package br.com.philipesantos.sortingservice.operations;

public class SwapOperation implements ExecutableOperation {
	
	private int indexSwapped;
	private int indexSwappedBy;
	
	public SwapOperation(int indexSwapped, int indexSwappedBy) {
		this.indexSwapped = indexSwapped;
		this.indexSwappedBy = indexSwappedBy;
	}
	
	public String getType() {
		return "SWAP";
	}
	
	public int getIndexSwapped() {
		return indexSwapped;
	}
	
	public int getIndexSwappedBy() {
		return indexSwappedBy;
	}
	
	@Override
	public void execute(Integer[] numbers) {
		Integer aux = numbers[indexSwapped];
		numbers[indexSwapped] = numbers[indexSwappedBy];
		numbers[indexSwappedBy] = aux;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SwapOperation)) {
			return false;
		}
		SwapOperation anotherSwap = (SwapOperation) obj;
		return (this.indexSwapped == anotherSwap.indexSwapped && this.indexSwappedBy == anotherSwap.indexSwappedBy) ||
				(this.indexSwapped == anotherSwap.indexSwappedBy && this.indexSwappedBy == anotherSwap.indexSwapped);
	}
	
	@Override
	public String toString() {
		return this.getType() + " (" + this.indexSwapped + ", " + this.indexSwappedBy + ")";
	}
}
