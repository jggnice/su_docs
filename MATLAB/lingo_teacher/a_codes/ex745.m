% 大学数学实验|2  p.139-140|144-145,161-162|155-156 实验7 例2|3  飞机精确定位问题
clear
X = [746, 629, 1571, 155];
Y = [1393, 375, 259, 987];
theta = [ 161.2, 45.1, 309.0 - 360 ] * 2* pi /360;
sigma =  [ 0.8, 0.6, 1.3 ] * 2* pi /360;
d4 = 864.3;
sigma4 = 2.0;
x0 = [900, 700];
[x, norm1, res1, exit1, out1] = lsqnonlin(@ex745f, x0, [], [], [], X, Y, theta, sigma, d4, sigma4)
%运行结果
% x =  978.3070  723.9838
%norm1 =  0.6685
%res1 =   -0.4361   -0.1225   -0.6807   -0.0007
%exit1 =     1
%out1 = 
%    firstorderopt: 1.4282e-008
%       iterations: 7
%       funcCount: 22
%     cgiterations: 6
%        algorithm: [1x43 char]

