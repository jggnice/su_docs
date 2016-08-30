% 大学数学实验|2  p.277-278|290  实验11|12  例3 两总体均值检验 
% 分别用 N(5, 1) 和 N(5.2, 0.8^2 ) 产生 n = 100 的样本, 分别在两
% 个总体标准差已知和未知的情况下检验H0: mu1 = mu2 (alpha = 0.05) 
x = normrnd(5,    1,  100,1);
y = normrnd(5.2,0.8,100,1);
[hz,sigz,ciz,statz] = ztest2(x,y,1,0.8) 
[ht,sigt,cit,statt] = ttest2(x,y) 