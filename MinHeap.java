

public class MinHeap
{
    int capacity;
    int size = 0;
    Node[] arr;

    public MinHeap(int capacity)
    {
        this.capacity = capacity;
        arr = new Node[capacity];
    }

    public MinHeap(Node[] arr)
    {
        this.arr = arr;
        this.capacity = arr.length;
        size = arr.length-1;
    }

    public int getLeftChildIndex(int parentIndex)
    {
        return (2 * parentIndex + 1);
    }

    public int getRightChildIndex(int parentIndex)
    {
        return (2 * parentIndex + 2);
    }

    public int getParentIndex(int childIndex)
    {
        return (childIndex - 1) / 2;
    }
    public void swap(int parentIndex, int childIndex)
    {
        Node parent = arr[parentIndex];
        Node child = arr[childIndex];
        arr[childIndex] = parent;
        arr[parentIndex] = child;
    }

    // heapify's up from index
    public void heapify(MinHeap A, int index)
    {
        int parentIndex = getParentIndex(index);
        while(parentIndex >= 0)
        {
            int leftIndex = getLeftChildIndex(parentIndex);
            int rightIndex = getRightChildIndex(parentIndex);

            double parentDistance = A.arr[parentIndex].distance;

            double leftDistance = Double.MAX_VALUE;
            if(A.arr[leftIndex] != null)
                leftDistance = A.arr[leftIndex].distance;

            double rightDistance = Double.MAX_VALUE;
            if(A.arr[rightIndex] != null)
                rightDistance = A.arr[rightIndex].distance;

            if(leftDistance <= rightDistance && leftDistance < parentDistance)
            {
                swap(parentIndex, leftIndex);
                parentIndex = getParentIndex(parentIndex);
            }
            else if(rightDistance < parentDistance)
            {
                swap(parentIndex, rightIndex);
                parentIndex = getParentIndex(parentIndex);
            }
            else
                break;
        }
    }

    public void heapifyDown(MinHeap A, int parentIndex)
    {
        while(parentIndex < size-2)
        {
            int leftIndex = getLeftChildIndex(parentIndex);
            int rightIndex = getRightChildIndex(parentIndex);

            double parentDistance = A.arr[parentIndex].distance;

            double leftDistance = Double.MAX_VALUE;
            if(A.arr[leftIndex] != null)
                leftDistance = A.arr[leftIndex].distance;

            double rightDistance = Double.MAX_VALUE;
            if(A.arr[rightIndex] != null)
                rightDistance = A.arr[rightIndex].distance;

            if(leftDistance <= rightDistance && leftDistance < parentDistance)
            {
                swap(parentIndex, leftIndex);
                parentIndex = leftIndex;
            }
            else if(rightDistance < parentDistance)
            {
                swap(parentIndex, rightIndex);
                parentIndex = rightIndex;
            }
            else
                break;
        }
    }


    public void insert(MinHeap A, Node node)
    {
        double value = node.distance;
        if(A.size < A.capacity)
        {
            A.arr[A.size] = node;
            A.size++;
            heapify(A, A.size - 1);
        }
    }

    //deletes from root
    public Node delete(MinHeap A)
    {
        Node first = A.arr[0];
        Node last = A.arr[size - 1];
        A.arr[0] = last;
        A.arr[--A.size] = null;

        heapifyDown(A, 0);

        return first;
    }


    public void print()
    {
        for(int i=0; i<size; i++)
        {
            System.out.print(arr[i].distance + " ");
        }
        System.out.println();
    }




}
