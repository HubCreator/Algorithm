public class Main {

    private static int sorted[];

    public static void main(String[] args) {
        Main T = new Main();
        int[] arr = new int[]{15, 4, 3, 2, 1};
        sorted = new int[arr.length];

        T.insertion(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - 1 - i; j++)
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
    }

    void selection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    void insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public void mergeSort(int[] arr, int lt, int rt) {
        if (lt < rt) {
            int mid = (rt - lt) / 2 + 1;
            mergeSort(arr, lt, mid);
            mergeSort(arr, mid + 1, rt);
            merge(arr, lt, mid, rt);
        }
    }

    private void merge(int[] arr, int lt, int mid, int rt) {
        int i = lt, j = mid + 1, k = lt, l;

        while (i <= mid && j <= rt) {
            if (arr[i] <= arr[j]) {
                sorted[k++] = arr[i++];
            } else {
                sorted[k++] = arr[j++];
            }
        }
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
