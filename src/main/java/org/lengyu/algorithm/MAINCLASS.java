package org.lengyu.algorithm;

public class MAINCLASS {
    public static void main(String[] args) {
        doLeetcodeOfferTest();
    }

    public static void doLeetcodeOfferTest() {
        ProblemTester offerTester = new ProblemTester("org.lengyu.algorithm.solution.leetcode.offer.Solution{}",
                "data/leetcode/offer/Solution{}.txt");
        offerTester.openPlusMode();

        offerTester.test("3");
        offerTester.test("7");
        offerTester.test("9");
        offerTester.test("11");
        offerTester.test("12");
        offerTester.test("13");
        offerTester.test("15");
        offerTester.test("16");
        offerTester.test("17");
        offerTester.test("33");
        offerTester.test("34");
        offerTester.test("38");
        offerTester.test("39");
        offerTester.test("40");
        offerTester.test("41");
        offerTester.test("44");
        offerTester.test("45");

        offerTester.test("49");
        offerTester.test("50");
        offerTester.test("51");


        offerTester.test("57");
        offerTester.test("60");
        offerTester.test("61");
        offerTester.test("62");
        offerTester.test("64");
        offerTester.test("65");
        offerTester.test("66");

        offerTester.test("141");
        offerTester.test("142");
        offerTester.test("321");
        offerTester.test("322");
        offerTester.test("323");
        offerTester.test("431");
        offerTester.test("531");
        offerTester.test("532");

        offerTester.test("551");
        offerTester.test("552");
        offerTester.test("561");
        offerTester.test("562");
        offerTester.test("572");
        offerTester.test("581");
        offerTester.test("591");
        offerTester.test("592");

        offerTester.test("BinarySearch");
        offerTester.test("Sort");

        //不支持的题目

        //序列化二叉树，特殊测试
        // offerTester.test("37");

        //两个链表的第一个节点，复制复杂链表，特殊输入
        // offerTester.test("52");
        // offerTester.test("54");

        //二叉搜索树/二叉树的最近公共祖先，特殊输入
        // offerTester.test("681");
        // offerTester.test("682");

        //二叉搜索树转化为双向链表，特殊输出
        // offerTester.test("36");
    }
}
