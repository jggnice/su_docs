% 大学数学实验|2  p.174-175|179-180, p.175|185, p176|186  实验8 例1  求解线性规划
% max z = 3x1 + x2      ==> min -3x1 - x2 
% s.t.  x1 –  x2 >= –2    ==> -x1 + x2 <= 2
%        x1 –  2 x2 <= 2
%        3 x1 + 2 x2 <= 14
%      x1, x2 >= 0
clear
format short

A = [-1 1; 1 -2; 3 2];
b = [2 2 14]';
c = [-3 -1]';
v1 = [ 0 0 ]; 	% 下界

'***** p175，计算10个基解******'
% p175，计算10个基解，
%               ans1中前3个为基变量的列号，
%              后5列为基解，分量全>=0的是基可行解（共5个）
m = size(A,1); 	% A 的行数
A1 = [A, eye(m)];	% 加入m个松弛变量
n = size(A1, 2); 	% A1 的列数
nn = 1:n;
n0 = zeros(1,5);
ans1 = [];
for  i = 1:n-1	% k个变量有k重循环
    for j = i+1:n
       ij = nn;
       ij( [i, j] ) = [] ;    	% 删去1:n中的i, j元素
       B = A1(:, ij );	% 取出A中所需m列
       xB = (B\b)';	
       x = zeros(1,5);
       x( ij ) = xB ;
       ans1 = [ans1; ij, x];
   end
end
ans1

'*****p.176|185 用linprog函数求解************'
[ x, f, exitflag, output, lamda ] = linprog( c, A, b, [], [], v1 )
lamda_ineqlin = lamda.ineqlin
lamda_eqlin = lamda.eqlin
lamda_upper = lamda.upper
lamda_lower = lamda.lower

' = = = = p.177|186 有效集方法 = = = = '
opt1 = optimset('Largescale', 'off');
[ x, f, exitflag, output, lamda ] = linprog( c, A, b, [], [], [], [], [], opt1 )
' = = = = p.177|186 单纯形算法 = = = = '
opt2 = optimset(opt1, 'simplex', 'on');	% 6.5版中无simplex选项
[ x, f, exitflag, output, lamda ] = linprog( c, A, b, [], [], [], [], [], opt2 )

% 运行结果
% ans1 = 
% 3	4	5	0	0	2	2	14
% 2	4	5	0	2	0	6	10
% 2	3	5	0	-1	3	0	16
% 2	3	4	0	7	-5	16	0
% 1	4	5	-2	0	0	4	20
% 1	3	5	2	0	4	0	8
% 1	3	4	4.6667	0	6.6667	-2.6667	0
% 1	2	5	-6	-4	0	0	40
% 1	2	4	2	4	0	8	0
% 1	2	3	4	1	5	0	0
%Optimization terminated successfully.
%x =
%    4.0000
%    1.0000
%f =   -13.0000
%exitflag =     1
%output = 
%        iterations: 5
%    cgiterations: 0
%        algorithm: 'lipsol'
%lamda = 
%    ineqlin: [3x1 double]
%      eqlin: [0x1 double]
%      upper: [2x1 double]
%      lower: [2x1 double]
% amda_ineqlin =
%    0.0000		% 该约束不起作用
%    0.3750		% 这是影子价格(p.187-188)
%    0.8750		% 这是影子价格(p.187-188)
%lamda_eqlin =
%   Empty matrix: 0-by-1
%lamda_upper =
%     0			% 该约束不起作用
%     0			% 该约束不起作用
%lamda_lower =
%  1.0e-008 *
%                    0.1075		
%                    0.2942

%  **********以下是2008版的输出************

% = = = = p.177 有效集方法 = = = = 
%Optimization terminated.
% x =
%     4
%     1
%f =   -13
%exitflag =     1
%output = 
%      iterations: 2
%       algorithm: 'medium-scale: active-set'
%    cgiterations: []
%         message: 'Optimization terminated.'
%lamda = 
%      lower: [2x1 double]
%      upper: [2x1 double]
%      eqlin: [0x1 double]
%    ineqlin: [3x1 double]

% = = = = p.177 单纯形算法 = = = = 
%Optimization terminated.
%x =
%     4
%     1
%f =   -13
%exitflag =     1
%output = 
%      iterations: 2
%       algorithm: 'medium scale: simplex'
%    cgiterations: []
%         message: 'Optimization terminated.'
%lamda = 
%    ineqlin: [3x1 double]
%      eqlin: [0x1 double]
%      upper: [2x1 double]
%      lower: [2x1 double]


  