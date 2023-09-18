# parse info.json

import json
import os

file = open('info.json', 'r')
json_data = json.load(file)
file.close()
# sort json_data keys
json_data = {k: json_data[k] for k in sorted(json_data, key=lambda x: json_data[x]['date'], reverse=True)}

# iterate over every key in info.json
for key in json_data:
    name = json_data[key]['problem']
    # search for a file in the "submissions" directory whose name is "name" but with a different extension
    for filename in os.listdir('submissions'):
        split = filename.split('.')
        if split[0] == key:
            # continue if file exists
            if os.path.exists(os.path.join('submissions', name + '.' + split[1])):
                os.remove(os.path.join('submissions', filename))
                continue
            os.rename(os.path.join('submissions', filename), os.path.join('submissions', name + '.' + split[1]))
            print('Renamed ' + filename + ' to ' + name + split[1])