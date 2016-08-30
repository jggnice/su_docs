function dx=huojian(t,x)
m0=1400;ms=18;F0=32000;
mt=m0-ms*t;f1=0.4*x(2)^2;
dx=[x(2);(F0-f1-9.8*mt)/mt];