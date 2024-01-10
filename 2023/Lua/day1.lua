-- Lua 5.4.6

function openfile(filepath)
    local file = io.open(filepath)

    if file == nil then
        local error_message = string.format("cannot open file at path \"%s\"", filepath)
        error(error_message)
    end

    return file
end


local filepath = "../inputs/day1.txt"
local success, file = pcall(openfile, filepath)
Total = 0

if success then
    for line in file:lines() do
        local numbers = {}
    
        for i = 1, #line do
            local character = string.sub(line, i, i)
    
            if tonumber(character) then
                table.insert(numbers, character)
            end
        end
    
        -- I often forgot that array index in Lua start at 1
    
        if #numbers >= 2 then
            local number = numbers[1] .. numbers[#numbers]
            Total = Total + tonumber(number)
        elseif #numbers == 1 then
            local number = numbers[1] .. numbers[1]
            Total = Total + tonumber(number)
        end
    end
    
    print(Total)

else
    print("Error:", file)
end