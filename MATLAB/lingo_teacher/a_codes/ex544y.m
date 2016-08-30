% 大学数学实验2 p.92-93, 107-110 实例3  按年龄分组的种群增长
% 大学数学实验  p.31-34  2.3.2     例5  按年龄分组的种群增长
% 动物因自然或人工繁殖而增加，因自然死亡和人为屠杀而减少;
% 不同年龄动物的繁殖率、死亡率有较大差别;
% 将种群按年龄等间隔地分成若干个年龄组，时间离散化为时段;
% 在稳定环境下假定各年龄组种群的繁殖率和死亡率与时段无关;
% 第 i 年龄组 1 雌性个体在 1 时段内的繁殖率为 bi  
% 第 i 年龄组在 1 时段内的死亡率为 di, 存活率为 si = 1 – di  
% 设一种群分成 n = 5 个年龄组, 繁殖率 b1 ~ b5 = 0, 0.2, 1.8, 0.8, 0.2,
% 存活率 s1 ~ s4 = 0.5, 0.8, 0.8, 0.1, 各年龄组现有数量均为100 ．
%
% p.110/p.34  用本例的数据对上面的稳态分析作验证
%
b = [ 0, 0.2, 1.8, 0.8, 0.2 ];
s0 = [ 0.5, 0.8, 0.8, 0.1 ];
s = diag(s0);	% 生成对角阵，对角元素为0.5, 0.8, 0.8, 0.1
L = [ b; s, zeros(4,1) ];	% 按照 p.93(5.12)式构造矩阵L
[eigv,eigd] = eig(L);
lamda=eigd(1)
v1=eigv(:,1);
v1=v1/sum(v1)			% 归一化最大特征值对应的特征向量x*
xstar(1) = 1;
for k = 1:4
    xstar(k+1) = xstar(k)*s0(k)/lamda;
end
xstar1 = (xstar/sum(xstar))'	% 按(75)式计算的x*

[eigv,eigd] = eig(L);

x(:,1) = 100*ones(5,1);	% 赋初值
n = 30;
for k = 1:n
    x(:,k+1) = L*x(:,k);	% 按p.93(5.13)式迭代计算
end
y = diag([1./sum(x)]);		% 为向量归一化做的计算
z = x*y;			% z是向量x的归一化
z1=z(:,31)			% 30次迭代后的x~, 近似x*
