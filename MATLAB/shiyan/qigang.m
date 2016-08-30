format long
clc;clear;
a=0.8;b=0.25;r=0.04;l0=0.5;p0=10000;v=1.4;F=25;
S=pi*r^2;
opt = optimset('TolX',1e-10);
[x,y]=...
fzero(@(x)F*a*cos(x)-S*b*p0*(l0/(l0-b*tan(x)))^v,0.4,opt)
degree=x*180/pi
format short