% p.267-268

n = 100000;  format long

% 1. ���Ͷ�㷨���� pi
tic
x = rand(2,n);
k = 0;
for i = 1:n
   if x(1,i)^2+x(2,i)^2<=1
      k=k+1;
   end
end
p = 4*k/n
disp(['��ʱ',num2str(toc)])

% �������ĳ���1
tic
x = rand(2,n);		% ע�ʹ˾䣬�ɱȽ���������ļ�����(��ȫ��ͬ)
k = length( find(x(1,:).^2+x(2,:).^2<=1) );
p = 4*k/n
disp(['��ʱ',num2str(toc)])


% 2. ��ֵ���Ʒ����� pi 
tic
x = rand(1,n);
y = 0;
for i = 1:n
   y = y + sqrt(1 - x(i)^2); 
end
p = 4*y/n
disp(['��ʱ',num2str(toc)])

% �������ĳ���2
tic
x = rand(1,n);		% ע�ʹ˾䣬�ɱȽ���������ļ�����(��ȫ��ͬ)
y = sum( sqrt(1-x.^2) );
p = 4*y/n
disp(['��ʱ',num2str(toc)])




