function dx=huojian2(t1,y)
mm=(1400-1080);
f1=0.4*y(2)^2;
dx=[y(2);-(mm*9.8+f1)/mm];