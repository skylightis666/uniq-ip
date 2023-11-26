import random
import os


def hlp():
    return random.randint(1, 254)


script_dir = os.path.dirname(__file__)
rel_path = "test3"
abs_file_path = os.path.join(script_dir, rel_path)

# Open the output file for writing
with open(abs_file_path, "w") as f:
    # Generate 10 random IP addresses and write them to the file
    for i in range(1_000_000_000):
        ip_address = '%d.%d.%d.%d' % (hlp(), hlp(), hlp(), hlp())
        f.write(ip_address + "\n")
