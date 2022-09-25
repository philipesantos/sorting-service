package br.com.philipesantos.sortingservice.operations;

public class SwapOperation implements ExecutableOperation {
	
	private final int indexSwapped;
	private final int indexSwappedBy;
	
	public SwapOperation(int indexSwapped, int indexSwappedBy) {
		this.indexSwapped = indexSwapped;
		this.indexSwappedBy = indexSwappedBy;
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
		if (!(obj instanceof SwapOperation anotherSwap)) {
			return false;
		}
		boolean equalsSamePosition = this.indexSwapped == anotherSwap.indexSwapped &&
				this.indexSwappedBy == anotherSwap.indexSwappedBy;
		boolean equalsDifferentPosition = this.indexSwapped == anotherSwap.indexSwappedBy &&
				this.indexSwappedBy == anotherSwap.indexSwapped;
		return equalsSamePosition || equalsDifferentPosition;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " (" + this.indexSwapped + ", " + this.indexSwappedBy + ")";
	}
}
