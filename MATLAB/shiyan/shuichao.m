format long
clc;clear;
L=25.4;r=2;V=100;
opt = optimset('TolX',1e-10);
[x,y]=...
fzero(@(x)(acos(x/r)*r*r-x*sqrt(r*r-x*x))-V/L,1,opt)
format short