package cn.limy.test.designPatterns.templateMode;

abstract class AbstractCake{
    protected boolean shouldApply(){
        return true;
    }
    protected abstract void shape();
    protected abstract void apply();
    protected abstract void brake();
    public final void run(){
        this.shape();
        if(this.shouldApply()){
            this.apply();
        }
        this.brake();
    }
}