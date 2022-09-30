package br.com.philipesantos.sortingservice.algorithms;

import br.com.philipesantos.sortingservice.operations.CompareOperation;
import br.com.philipesantos.sortingservice.operations.ExecutableOperation;
import br.com.philipesantos.sortingservice.operations.Operation;
import br.com.philipesantos.sortingservice.operations.SwapOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuickSortAlgorithm implements SortAlgorithm {
    @Override
    public boolean isNamed(String algorithmName) {
        return "QUICK_SORT".equalsIgnoreCase(algorithmName);
    }

    @Override
    public List<Operation> sort(Integer[] numbers) {
        List<Operation> operations = new ArrayList<>();
        this.quickSort(numbers, 0, numbers.length - 1, operations);
        return operations;
    }

    private void quickSort(Integer[] numbers, Integer low, Integer high, List<Operation> operations)
    {
        if (low < high) {
            int pi = partition(numbers, low, high, operations);
            quickSort(numbers, low, pi - 1, operations);
            quickSort(numbers, pi + 1, high, operations);
        }
    }

    private int partition(Integer[] numbers, Integer low, Integer high, List<Operation> operations) {
        int pivot = numbers[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            operations.add(new CompareOperation(j, high));
            if (numbers[j] < pivot) {
                i++;
                if (i != j) {
                    ExecutableOperation swapOperation = new SwapOperation(i, j);
                    swapOperation.execute(numbers);
                    operations.add(swapOperation);
                }
            }
        }
        if (i + 1 != high) {
            ExecutableOperation swapOperation = new SwapOperation(i + 1, high);
            swapOperation.execute(numbers);
            operations.add(swapOperation);
        }
        return (i + 1);
    }
}
