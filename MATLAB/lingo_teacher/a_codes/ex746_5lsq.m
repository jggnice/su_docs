% ��ѧ��ѧʵ��  p.156~160  ��7.05      p.158 ����С���˷�
% ��� min 100 ( x2 - x1^2 )^2 + ( 1 - x1 )^2  
% ��ֵ [ -1.9, 1] 

x0 = [ -1.9, 2 ];

opt1 = optimset('LargeScale', 'off', 'MaxFunEvals', 1000);
[x1, norm1, res1, exit1, out1] = lsqnonlin('ex746_5fl', x0, [], [], opt1)
opt2 = optimset(opt1, 'LevenbergMarquardt', 'off');
[x2,  norm1, res1, exit2, out2] = lsqnonlin('ex746_5fl', x0, [], [], opt2)

