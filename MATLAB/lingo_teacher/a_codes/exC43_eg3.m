% 大学数学实验|2  p.262|276, p.281-284|293-297
% 实验11|12 实例3   如何制定汽油供货合同
%某炼油厂（甲方）向加油站（乙方）成批（车次）供货，双方制定了相关的产品
%质量监控合同，要求含硫量不超过 0.08%。若双方商定每批抽检10辆车，10个含硫量数据(%)：
%0.0864    0.0744    0.0864    0.0752    0.0760   0.0954    0.0936    0.1016    0.0800    0.0880
%1）只根据这些数据推断乙方是否应接受该批汽油；如果甲方是可靠的供货商, 并且对产品的
% 稳定性提供了进一步的信息，乙方对应的策略有什么变化？（假设检验）
%2）现乙方与一新炼油厂（丙方）谈判，并且风闻丙方有用含硫量 0.086% 的汽油顶替合格
%品的前科，那么如果乙方沿用与甲方订的合同, 会有什么后果？（假设检验）

%1)
% ① 显著性水平 alpha = 0.05，方差未知的情况下 
x = [0.0864    0.0744    0.0864    0.0752    0.0760   0.0954    0.0936    0.1016    0.0800    0.0880];
xbar = mean(x) ;           	% 样本均值
[h,sig]=ttest(x,0.08,0.05,1)  	% t(单侧)检验

% ② 显著性水平alpha = 0.05，标准差为sigma = 0.01 
[h, sig]=ztest(x,0.08,0.01,0.05,1)  % z(单侧)检验  

% ③ 显著性水平alpha = 0.05，标准差为sigma = 0.015
[h, sig]=ztest(x,0.08,0.015,0.05,1)  % z(单侧)检验  

% ④ 若对甲方产品的信任度很高，不妨将显著性水平由 alpha = 0.05 改为 0.01， 重新计算。
[h, sig] = ttest(x,0.08,0.01,1)  	% t(单侧)检验  

% 2) p.283|295
mu0 = 0.08; mu2 = 0.086; n = length(x);
alpha = [0.01 0.05 0.1 0.2 0.3];
talpha = tinv( 1 - alpha, n - 1);
s = std(x);
gap = (mu2 - mu0)/(s/sqrt(n));
beta = tcdf(talpha - gap, n - 1)

