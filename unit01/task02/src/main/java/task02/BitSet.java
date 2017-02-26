package task02;

public class BitSet {

    private long[] data = new long[1];

    public void add(int value){

        if(value < 0){
            return;
        }

        if(data.length * 64 - 1 < value){
            int dimension = value/64 + 1;
            long[] extData = new long [dimension];

            for(int i = 0; i < data.length; i++){
                extData[i] = data[i];
            }

            data = extData;
        }

        int index = value/64;
        data[index] |= 1L << (value%64);
    }

    public void remove(int value){

        if(value < 0 || value > data.length * 64 - 1){
            return;
        }

        int index = value/64;
        data[index] &= ~(1L << (value%64));
    }

    public boolean contains(int value){

        if(value < 0 || value > data.length * 64 - 1){
            return false;
        }

        int index = value/64;
        final long mask = 1L << (value%64);
        final long res = data[index] & mask;
        return res != 0;

    }

    public BitSet union(BitSet other){
        final BitSet setResult = new BitSet();

        long[] extData;
        int maxDimension = Integer.max(this.data.length, other.data.length);
        int minDimension = Integer.min(this.data.length, other.data.length);

        extData = new long[maxDimension];

        for(int i = 0; i < minDimension; i++){
            extData[i] = this.data[i] | other.data[i];
        }

        long[] longestData;
        if(maxDimension == this.data.length){
            longestData = this.data;
        }
        else{
            longestData = other.data;
        }
        for(int i = minDimension; i < maxDimension; i++){
            extData[i] = longestData[i];
        }

        setResult.data = extData;

        return setResult;
    }

    public BitSet intersection(BitSet other){
        final BitSet setResult = new BitSet();

        long[] extData;
        int maxDimension = Integer.max(this.data.length, other.data.length);
        int minDimension = Integer.min(this.data.length, other.data.length);

        extData = new long[maxDimension];

        for(int i = 0; i < minDimension; i++){
            extData[i] = this.data[i] & other.data[i];
        }

        long[] longestData;
        if(maxDimension == this.data.length){
            longestData = this.data;
        }
        else{
            longestData = other.data;
        }
        for(int i = minDimension; i < maxDimension; i++){
            extData[i] = longestData[i];
        }

        setResult.data = extData;

        return setResult;
    }

    public BitSet difference(BitSet other){
        final BitSet setResult = new BitSet();

        long[] extData;
        int maxDimension = Integer.max(this.data.length, other.data.length);
        int minDimension = Integer.min(this.data.length, other.data.length);

        extData = new long[maxDimension];

        for(int i = 0; i < minDimension; i++){
            extData[i] = this.data[i] & (~ other.data[i]);
        }

        long[] longestData;
        if(maxDimension == this.data.length){
            longestData = this.data;
        }
        else{
            longestData = other.data;
        }
        for(int i = minDimension; i < maxDimension; i++){
            extData[i] = longestData[i];
        }

        setResult.data = extData;

        return setResult;
    }

    public boolean isSubsetOf(BitSet other){

        int maxDimension = Integer.max(this.data.length, other.data.length);
        int minDimension = Integer.min(this.data.length, other.data.length);

        for(int i = 0; i < minDimension * 64; i++){
            if(this.contains(i) && ! other.contains(i)){
                return false;
            }
        }

        if(maxDimension == other.data.length){
            return true;
        }
        else{
            for(int i = minDimension * 64; i < maxDimension * 64; i++){
                if(this.contains(i)){
                    return false;
                }
            }
            return true;
        }
    }
}
