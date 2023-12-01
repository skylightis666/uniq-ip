import random
import socket
import struct
import os
import time


script_dir = os.path.dirname(__file__)
rel_path = "test_120gb"
abs_file_path = os.path.join(script_dir, rel_path)

t0 = time.time()
with open(abs_file_path, "w") as f:
    for i in range(8_000):
        f.write('\n'.join(socket.inet_ntoa(struct.pack('>I', random.randint(1, 0xffffffff))) for _ in range(10**6) ))

d = time.time() - t0
print("duration: %.2f s." % d)