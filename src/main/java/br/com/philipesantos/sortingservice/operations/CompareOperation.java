package br.com.philipesantos.sortingservice.operations;

public class CompareOperation implements Operation {
	
	private int indexCompared;
	private int indexComparedWith;
	
	public CompareOperation(int indexCompared, int indexComparedWith) {
		this.indexCompared = indexCompared;
		this.indexComparedWith = indexComparedWith;
	}
	
	public String getType() {
		return "COMPARE";
	}
	
	public int getIndexCompared() {
		return indexCompared;
	}
	
	public int getIndexComparedWith() {
		return indexComparedWith;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof CompareOperation)) {
			return false;
		}
		CompareOperation anotherCompare = (CompareOperation) obj;
		return (this.indexCompared == anotherCompare.indexCompared && this.indexComparedWith == anotherCompare.indexComparedWith) ||
				(this.indexCompared == anotherCompare.indexComparedWith && this.indexComparedWith == anotherCompare.indexCompared);
	}
	
	@Override
	public String toString() {
		return this.getType() + " (" + this.indexCompared + ", " + this.indexComparedWith + ")";
	}
}
