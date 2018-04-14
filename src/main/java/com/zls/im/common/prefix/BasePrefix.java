package com.zls.im.common.prefix;

public abstract class BasePrefix implements KeyPrefix {


    private  int expireSeconds;
    private String prefix;


    public BasePrefix(String prefix){
        this(0,prefix);//0代表永不过期
    }

    public BasePrefix(int expireSeconds, String prefix){
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }
    /**
     * 默认0代表永不过期
     * @return
     */
    @Override
    public int expireSeconds() {
        return 0;
    }

    @Override
    public String getPrefix() {

        String className = getClass().getSimpleName();
        return className+":"+prefix;
    }
}
