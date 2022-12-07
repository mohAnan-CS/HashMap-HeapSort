package project;

public class FreqYear implements Comparable<FreqYear> {

    private int freq;
    private int year;

    public FreqYear(int freq, int year) {
        this.freq = freq;
        this.year = year;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "{" +
                "freq=" + freq +
                ", year=" + year +
                '}';
    }

    @Override
    public int compareTo(FreqYear o) {

        if (o.freq > this.freq)
            return -1;
        else if (o.freq < this.freq)
            return 0;
        else
            return 0;

    }
}
