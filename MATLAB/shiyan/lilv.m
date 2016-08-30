format long
clc;clear;
opt = optimset('TolX',1e-10);
[x,y]=fzero(@(x)50*(1+12*x)^20-4.5*((1+12*x)^20-1)/(12*x),0.002,opt);