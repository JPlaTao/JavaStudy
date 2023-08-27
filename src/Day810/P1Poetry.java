package Day810;

public class P1Poetry {
    public static void main(String[] args) {
        char[][] poem = new char[][]{
                {'十', '年', '生', '死', '两', '茫', '茫'},
                {'千', '里', '孤', '坟'},
                {'无', '处', '话', '凄', '凉'},
                {'纵', '使', '相', '逢', '应', '不', '识'},
                {'尘', '满', '面'},
                {'鬓', '如', '霜'},
                {'夜', '来', '幽', '梦', '忽', '还', '乡'},
                {'小', '轩', '窗'},
                {'正', '梳', '妆'},
                {'相', '顾', '无', '言'},
                {'惟', '有', '泪', '千', '行'},
                {'料', '得', '年', '年', '肠', '断', '处'},
                {'明', '月', '夜'},
                {'短', '松', '冈'},
        };

        for (int i = 0; i < poem[0].length; i++) {
            for (int j = poem.length - 1; j >= 0; j--) {
                if (i <= poem[j].length - 1) {
                    System.out.print(poem[j][i] + "\t");
                } else
                    System.out.print("\t");
            }
            System.out.println();
        }

    }
}
