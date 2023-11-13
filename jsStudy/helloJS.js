function myQuickSort(arr, start, end) {
    if (start > end) {
        return;
    }
    let left = start;
    let right = end;
    let pivot = arr[left];
    while (left < right) {
        while (left < right && arr[right] >= pivot) {
            right--;
        }
        if (left < right) {
            arr[left] = arr[right];
        }
        while (left < right && arr[left] < pivot) {
            left++;
        }
        if (left < right) {
            arr[right] = arr[left];
        }
        if (left === right) {
            arr[left] = pivot;
        }
    }
    myQuickSort(arr, start, right - 1);
    myQuickSort(arr, left + 1, end);
}

let array = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5];
myQuickSort(array, 0, array.length - 1);
console.log(array);
