import os
from datetime import datetime, date, time, timedelta
import calendar
import re


def enum_jpg(dir):
    for file in os.listdir(dir):
        if file.endswith(".jpg"):
            os.rename(file, "a.jpg")


def is_valid_id(id_str: str):
    pattern = re.compile(r"\d{15}|\d{17}[\dxX]")
    match = pattern.fullmatch(id_str)
    if match:
        try:
            birth = date(year=int(id_str[6:10]),
                         month=int(id_str[10:12]),
                         day=int(id_str[12:14]))
        except:
            print("No")
        else:
            print(birth)
    else:
        print("No")


def day_of_leapy(year, month, day):
    if calendar.isleap(year):
        return date(year, month, day).timetuple().tm_yday


is_valid_id("510723200609183193")
print(day_of_leapy(2020, 9, 9))
