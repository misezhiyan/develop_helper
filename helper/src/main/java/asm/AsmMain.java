package asm;

import java.util.function.Consumer;

public class AsmMain {

    public static void main(String[] args) {
        Consumer c = System.out::println;
        c.accept("abc");
    }

    // asm 分为 core api  和  tree api
    // core api 包含 asm.jar, asm-util.jar, asm-commons.jar
    // tree api 包含 asm-tree.jar, asm-analysis.jar
}
