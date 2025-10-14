import torch

x = torch.randn(5, 3)
print(torch.cuda.is_available())
print(x)
