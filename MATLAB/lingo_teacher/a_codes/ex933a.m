% 大学数学实验2 p.200-201  p.210     实验9 实例1  投资组合问题
% 大学数学实验  p.169-171  p.188-189 实验8 实例2  投资组合问题
% min z =4 x1^2 + 36 x2^2 + 100 x3^2 + 5 x1x2 – 20 x1x3 – 30 x2x3    
% s.t.  5 x1 + 8 x2 + 10 x3 >= 1000 
%        20 x1 + 25 x2 + 30 x3 <= 5000  
%        x1, x2 ,x3 >= 0

H0 = [8  5  -20; 5  72  -30;-20  -30  200]; c = [ 0 0 0];
A = [-5  -8  -10; 20  25  30];  b = [-1000  5000];

[ x, fv, ef, output, lamda ] = quadprog( H0, c, A, b )
lamda_lower = lamda.lower
lamda_upper = lamda.upper
lamda_eqlin = lamda.eqlin
lamda_ineqlin = lamda.ineqlin

% 结果如下
%x =
%  131.1141
%   15.2853
%   22.2147
%fv =    6.8105e+004
%ef =     1
%output = 
%       iterations: 2
%        algorithm: 'medium-scale: active-set'
%    firstorderopt: []
%     cgiterations: []
%lamda = 
%      lower: [3x1 double]
%      upper: [3x1 double]
%      eqlin: [0x1 double]
%    ineqlin: [2x1 double]

%amda_lower =    [ 0     0    0 ]'
%lamda_upper =   [  0   0    0]'
%lamda_eqlin =     Empty matrix: 0-by-1
%lamda_ineqlin =  [   136.2092     0 ]'
