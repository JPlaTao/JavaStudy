package Day908_Genericity.am;

class Test{
//    TreeSet<Music> musicList = new TreeSet<Music>(new Comparator<Music>() {
//        @Override
//        public int compare(Music o1, Music o2) {
//            return (int) (o1.getDuration() - o2.getDuration());
//        }
//    })
//
//        TreeSet<Music> musicList = new TreeSet<Music>((m1,m2) -> (int) (m1.getDuration()- m2.getDuration()));

    static void main(String[] args) {
        MusicName<String> musicName = new Music<>("high way to hell",3.28);
        System.out.println(musicName.getName());
    }

}
interface MusicName<T>{
    public T getName();

}
class Music<T> implements MusicName<T> {
    private T name;

    private double duration;

    public Music() {
    }

    Music(T name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }

}
