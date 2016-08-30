% 大学数学实验2 p.200-201  p.210     实验9 实例1  投资组合问题
% 大学数学实验  p.169-171  p.188-189 实验8 实例2  投资组合问题
% min z = β Z2 - Z1    		% Z1--期望收益，z2 --期望风险(方差)
% s.t.  20 x1 + 25 x2 + 30 x3 <= 5000  
%        x1, x2 ,x3 >= 0
clear

H0 = [8  5  -20; 5  72  -30;-20  -30  200]; c = [ -5 -8 -10];
A = [20  25  30];  b = [5000];

opt = optimset('Large','off', 'Display','off');

for  i = 1:1000
    beta = 0.0001*i;
    H = beta*H0;
    x = quadprog( H, c, A, b, [], [], [0 0 0], [], [], opt );
    REV(i) = -c*x;		%计算期望收益
    STD(i) = sqrt(x'*H0*x/2);	%计算风险(标准差)
    xx(i,:) = x';
end
plot(REV,STD);
xlabel('预期收益/百元')
ylabel('标准差/百元')

RV=[REV',STD'];
