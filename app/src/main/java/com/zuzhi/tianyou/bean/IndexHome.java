package com.zuzhi.tianyou.bean;

import com.zuzhi.tianyou.entity.ImageEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanglw on 2016-1-28.
 */
public class IndexHome {
    public List<ImageEntity> bannerImageList;
    public List<AccessHistory> accessHistoryList;
    public List<BaGongGe> baGongGeList;
    public List<BaGongGe> keFuList;
    public List<SanGongGe> sanGongGeList;

    public int getCount() {
        return getCount1() + getCount2() + getCount3() + getCount4() + getCount5();
    }

    private int getCount1() {
        if (isEmpty(bannerImageList)) {
            return 0;
        }
        return 1;
    }

    private int getCount2() {
        if (isEmpty(accessHistoryList)) {
            return 0;
        }
        return 1;
    }

    private int getCount3() {
        if (isEmpty(baGongGeList)) {
            return 0;
        }
        int size = baGongGeList.size() / 4;
        if (baGongGeList.size() % 4 != 0) {
            size++;
        }
        return size;
    }

    private int getCount4() {
        //if (isEmpty(keFuList)) {
        //    return 0;
        //}
        return 1;
    }

    private int getCount5() {
        if (isEmpty(sanGongGeList)) {
            return 0;
        }
        return sanGongGeList.size();
    }

    public int getViewTypeByPosition(int position) {
        int[] counts = new int[]{getCount1(), getCount2(), getCount3(), getCount4(), getCount5()};
        int num = 0;
        for (int i = 0; i < counts.length; i++) {
            int num2 = num + counts[i];
            if (num == num2) {
                continue;
            }
            if (num2 > position) {
                return i;
            }
            num = num2;
        }
        return -1;
    }

    public int getBaGongGeStartPosition() {
        int[] counts = new int[]{getCount1(), getCount2()};
        int sum = 0;
        for (int count : counts) {
            sum += count;
        }
        return sum;
    }

    public List<BaGongGe> getBaGongGe(int position) {
        position = position - getBaGongGeStartPosition();
        if (position < 0 || position > baGongGeList.size()) {
            return null;
        }
        ArrayList<BaGongGe> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int index = position + i;
            if (index > baGongGeList.size()) {
                return list;
            }
            list.add(baGongGeList.get(index));
        }
        return list;
    }

    public int getSanGongGeStartPosition() {
        int[] counts = new int[]{getCount1(), getCount2(), getCount3(), getCount4()};
        int sum = 0;
        for (int count : counts) {
            sum += count;
        }
        return sum;
    }

    public SanGongGe getSanGongGe(int position) {
        position = position - getSanGongGeStartPosition();
        if (position < 0 || position >= sanGongGeList.size()) {
            return null;
        }
        return sanGongGeList.get(position);
    }

    public static boolean isEmpty(List list) {
        return list == null || list.isEmpty();
    }

    public static int size(List list) {
        if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }
}
