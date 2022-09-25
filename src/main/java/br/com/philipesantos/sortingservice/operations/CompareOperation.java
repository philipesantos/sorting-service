package br.com.philipesantos.sortingservice.operations;

public class CompareOperation implements Operation {

	private final int indexCompared;
	private final int indexComparedWith;

	public CompareOperation(int indexCompared, int indexComparedWith) {
		this.indexCompared = indexCompared;
		this.indexComparedWith = indexComparedWith;
	}

	public int getIndexCompared() {
		return indexCompared;
	}

	public int getIndexComparedWith() {
		return indexComparedWith;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof CompareOperation anotherCompare)) {
			return false;
		}
		boolean equalsSamePosition = this.indexCompared == anotherCompare.indexCompared &&
				this.indexComparedWith == anotherCompare.indexComparedWith;
		boolean equalsDifferentPosition = this.indexCompared == anotherCompare.indexComparedWith &&
				this.indexComparedWith == anotherCompare.indexCompared;
		return equalsSamePosition || equalsDifferentPosition;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " (" + this.indexCompared + ", " + this.indexComparedWith + ")";
	}
}
