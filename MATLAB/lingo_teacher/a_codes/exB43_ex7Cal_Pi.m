% p.267-268

n = 100000;  format long

% 1. 随机投点法计算 pi
tic
x = rand(2,n);
k = 0;
for i = 1:n
   if x(1,i)^2+x(2,i)^2<=1
      k=k+1;
   end
end
p = 4*k/n
disp(['用时',num2str(toc)])

% 王振羽编的程序1
tic
x = rand(2,n);		% 注释此句，可比较两个程序的计算结果(完全相同)
k = length( find(x(1,:).^2+x(2,:).^2<=1) );
p = 4*k/n
disp(['用时',num2str(toc)])


% 2. 均值估计法计算 pi 
tic
x = rand(1,n);
y = 0;
for i = 1:n
   y = y + sqrt(1 - x(i)^2); 
end
p = 4*y/n
disp(['用时',num2str(toc)])

% 王振羽编的程序2
tic
x = rand(1,n);		% 注释此句，可比较两个程序的计算结果(完全相同)
y = sum( sqrt(1-x.^2) );
p = 4*y/n
disp(['用时',num2str(toc)])




