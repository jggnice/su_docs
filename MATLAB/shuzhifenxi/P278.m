%%%%%  ÃÝ·¨ %%%%
% P278.m
A = [5 4 1 1 
     4 5 1 1 
     1 1 4 2 
     1 1 2 4];
v0 = ones(4,1);
vk = A*v0;
dx = 1e-8;
count = 0;
disp('k                            vk{T}                     max(Vk)')
while(max(abs(vk-v0))>dx)
    v0 = vk;
    vk = A*vk;
    tep = max(vk);
    vk = vk/tep;
    count = count + 1;
    disp([num2str(count) '         ('  num2str(vk')  ')        ' num2str(tep)])
    %max(abs(vk-v0))
end