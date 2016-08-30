% 大学数学实验2  p.174-175, p.187  实验8 实例1  食谱问题(新例)
% 每人每天需要 50g蛋白质，4000IU维生素A，1000mg
% 需要 苹果 香蕉 胡萝卜 枣汁 鸡蛋 x1g x2g x3g x4g x5g  
%          x5千克 A1加工 B1， x6千克 A2加工 B2 
% Min 10 x1 + 15 x2 + 5 x3 + 60 x4 + 8 x5  
% s.t.  0.3 x1 + 1.2 x2 + 0.7 x3 + 3.5 x4 + 5.5 x5 >= 50  
%       73 x1 + 96 x2 + 20253 x3 + 890 x4 + 279 x5 >= 4000    
%       9.6 x1 + 7 x2 + 19 x3 + 57 x4 + 22 x5 >= 1000 
%      x1, ..., x5 >= 0
clear
format short

'========p.187============'
c = [10 15 5 60 8];
A = [0.3 1.2 0.7 3.5 5.5
     73 96 20253 890 279 
     9.6  7 19 57 22];
b = [50 4000 1000];
v = [1 0 0 0 0];
% 由于问题规模很小，选用单纯形法求解  % 6.5版中无simplex选项
opt = optimset('Largescale', 'off', 'simplex', 'on');	
[x,z0,ef,out,lag] = linprog(c,-A,-b,[],[],v,[],[],opt) 
lag.ineqlin, lag.lower 

%运行结果
%Optimization terminated.
%x =      0
%         0
%   49.3827
%         0
%    2.8058
%z0 =  269.3603
%ef =     1
%out = 
%      iterations: 2
%       algorithm: 'medium scale: simplex'
%    cgiterations: []
%         message: 'Optimization terminated.'
%lag = 
%    ineqlin: [3x1 double]
%      eqlin: [0x1 double]
%      upper: [5x1 double]
%      lower: [5x1 double]
%ans =			<==lag.ineqlin:
%    0.4714
%         0
%    0.2458
%ans =			<==lag.lower
%    7.4990
%   12.7138
%         0
%   44.3401
%         0




