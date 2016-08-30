% 大学数学实验|2  p.275|288  实验11|12  例1 正态总体均值检验 
% 用 N(5, 1) 随机数产生 n = 100 的样本，分别在总体方差已知 
% 和未知的情况下检验总体均值 mu = 5 与 mu = 5.25 (alpha = 0.05 )。
x=normrnd(5,1,100,1);              
m=mean(x),                          % 样本均值
[h0,sig0,ci0,z0]=ztest(x,5,1)       % z检验
[h1,sig1,ci1,z1]=ztest(x,5.25,1)
[ht,sigt,cit]=ttest(x,5)            % t检验
[ht1,sigt1,cit1]=ttest(x,5.25)
