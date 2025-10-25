#include <algorithm>
#include <cmath>
#include <iostream>
#include <map>
#include <numeric>
#include <string>
#include <utility>
#include <vector>

using int128 = __int128;

long long gcd(long long a, long long b) {
    a = std::abs(a);
    b = std::abs(b);
    while (b) {
        a %= b;
        std::swap(a, b);
    }
    return a;
}

long long integer_sqrt(long long n) {
    if (n < 0) return -1;
    if (n == 0) return 0;

    long long low = 1, high = 3000000000LL;
    long long ans = 0;

    while (low <= high) {
        long long mid = low + (high - low) / 2;
        int128 mid_sq = (int128)mid * mid;

        bool overflow = false;
        if (mid != 0 && mid_sq / mid != mid) {
            overflow = true;
        }
        if (overflow || mid_sq < 0) {
            high = mid - 1;
            continue;
        }

        if (mid_sq == n) {
            return mid;
        } else if (mid_sq < n) {
            ans = mid;
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return ans;
}

bool is_perfect_square(long long n) {
    if (n < 0) return false;
    if (n == 0) return true;
    long long root = integer_sqrt(n);
    return (int128)root * root == n;
}

std::vector<long long> solve() {
    int n;
    std::cin >> n;
    std::vector<long long> a(n);
    int zero_idx = -1;
    bool has_zero = false;
    for (int i = 0; i < n; ++i) {
        std::cin >> a[i];
        if (a[i] == 0) {
            has_zero = true;
            zero_idx = i;
        }
    }

    if (n <= 1) {
        a[0] += 1;
        return a;
    }

    if (has_zero) {
        int k = zero_idx;
        long long P = -1, R = -1;

        if (n == 2) {
            if (k == 0) {
                if (a[1] > 0 && a[1] % 2 == 0) {
                    a[0] = a[1] / 2;
                } else {
                    a[0] = 1;
                }
                if (a[0] < 1) a[0] = 1;
            } else {
                if (a[0] == 0) {
                    a[0] = 1;
                    a[1] = 1;
                } else {
                    int128 temp_b1 = (int128)a[0] * 2;
                    if (temp_b1 >= 1 && temp_b1 <= 1000000000000000000LL) {
                        a[1] = (long long)temp_b1;
                    } else {
                        a[1] = a[0];
                        if (a[1] < 1) a[1] = 1;
                    }
                }
            }
        } else {
            if (k == 0) {
                if (a[1] <= 0 || a[2] <= 0) {
                    P = 2;
                    R = 1;
                } else {
                    long long common = gcd(a[1], a[2]);
                    P = a[2] / common;
                    R = a[1] / common;
                }
                if (P == 0) {
                    a[0] = 1;
                } else if (R == 0) {
                    a[0] = 1;
                } else if ((int128)a[1] * R % P != 0) {
                    a[0] = 1;
                } else {
                    a[0] = (long long)((int128)a[1] * R / P);
                }

            } else if (k == n - 1) {
                if (a[n - 3] <= 0 || a[n - 2] <= 0) {
                    P = 2;
                    R = 1;
                } else {
                    long long common = gcd(a[n - 3], a[n - 2]);
                    P = a[n - 2] / common;
                    R = a[n - 3] / common;
                }
                if (R == 0) {
                    a[k] = 1;
                } else if (P == 0 && a[n - 2] != 0) {
                    a[k] = 1;
                } else if ((int128)a[n - 2] * P % R != 0) {
                    a[k] = 1;
                } else {
                    a[k] = (long long)((int128)a[n - 2] * P / R);
                }

            } else {
                if (a[k - 1] <= 0 || a[k + 1] <= 0) {
                    P = 2;
                    R = 1;
                } else {
                    long long g = gcd(a[k - 1], a[k + 1]);
                    long long base1 = a[k - 1] / g;
                    long long base2 = a[k + 1] / g;
                    if (is_perfect_square(base1) && is_perfect_square(base2)) {
                        R = integer_sqrt(base1);
                        P = integer_sqrt(base2);
                        if (R == 0) {
                            if (P == 0) {
                                P = 1;
                                R = 1;
                            } else {
                                P = 2;
                                R = 1;
                            }
                        }
                    } else {
                        P = 2;
                        R = 1;
                    }
                }
                if (R == 0) {
                    a[k] = 1;
                } else if (P == 0 && a[k - 1] != 0) {
                    a[k] = 1;
                } else if ((int128)a[k - 1] * P % R != 0) {
                    a[k] = 1;
                } else {
                    a[k] = (long long)((int128)a[k - 1] * P / R);
                }
            }
            if (a[k] < 1) a[k] = 1;
            int128 test_val = (int128)a[k];
            if (test_val > 1000000000000000000LL) {
                if (k > 0 && a[k - 1] >= 1)
                    a[k] = a[k - 1];
                else if (k + 1 < n && a[k + 1] >= 1)
                    a[k] = a[k + 1];
                else
                    a[k] = 1;
            }
        }
        return a;
    }

    if (n == 2) {
        long long b2_candidate = -1;
        bool option1_valid = false;
        int128 test_b2 = (int128)a[0] * 2;
        if (a[0] >= 1 && test_b2 >= 1 && test_b2 <= 1000000000000000000LL) {
            b2_candidate = (long long)test_b2;
            option1_valid = true;
        }

        long long b1_candidate = -1;
        bool option2_valid = false;
        if (a[1] > 0 && a[1] % 2 == 0) {
            b1_candidate = a[1] / 2;
            option2_valid = (b1_candidate >= 1);
        }

        if (option1_valid) {
            a[1] = b2_candidate;
        } else if (option2_valid) {
            a[0] = b1_candidate;
        } else {
            if (a[0] >= 1 && a[1] >= 1) {
                if (a[0] < a[1])
                    a[1] = a[0];
                else
                    a[0] = a[1];
            } else {
                a[0] = 1;
                a[1] = 1;
            }
        }
        return a;
    }

    std::map<std::pair<long long, long long>, int> ratio_counts;
    std::vector<std::pair<long long, long long>> unique_ratios;

    for (int i = 0; i < n - 1; ++i) {
        if (a[i] == 0) continue;
        long long common = gcd(a[i + 1], a[i]);
        if (common == 0) continue;

        std::pair<long long, long long> ratio = {a[i + 1] / common, a[i] / common};

        if (ratio_counts.find(ratio) == ratio_counts.end()) {
            unique_ratios.push_back(ratio);
        }
        ratio_counts[ratio]++;
    }

    long long P = -1, R = -1;
    int k = -1;

    std::vector<long long> current_best_a = a;
    bool solution_found = false;

    std::vector<std::pair<long long, long long>> ratios_to_try;
    int max_freq = 0;
    std::pair<long long, long long> majority_ratio = {-1, -1};
    for (auto const &[ratio, freq] : ratio_counts) {
        if (freq > max_freq) {
            max_freq = freq;
            majority_ratio = ratio;
        }
    }
    if (majority_ratio.first != -1 || majority_ratio.second != -1) {
        ratios_to_try.push_back(majority_ratio);
    }
    for (const auto &ratio : unique_ratios) {
        if (ratio != majority_ratio) {
            ratios_to_try.push_back(ratio);
        }
    }

    if (n == 3 && ratio_counts.size() >= 2) {
        if (a[0] > 0 && a[2] > 0) {
            long long g = gcd(a[0], a[2]);
            long long base1 = a[0] / g;
            long long base2 = a[2] / g;
            if (is_perfect_square(base1) && is_perfect_square(base2)) {
                long long R_sqrt = integer_sqrt(base1);
                long long P_sqrt = integer_sqrt(base2);
                if (R_sqrt != 0) {
                    bool already_added = false;
                    for (const auto &r : ratios_to_try)
                        if (r.first == P_sqrt && r.second == R_sqrt) already_added = true;
                    if (!already_added) ratios_to_try.push_back({P_sqrt, R_sqrt});
                }
            }
        }
    }

    if (ratios_to_try.empty()) {
        ratios_to_try.push_back({2, 1});
        ratios_to_try.push_back({1, 1});
        ratios_to_try.push_back({1, 2});
    }

    for (auto const &current_ratio : ratios_to_try) {
        P = current_ratio.first;
        R = current_ratio.second;
        if (R == 0 && P != 0) continue;
        if (R == 0 && P == 0) continue;

        std::vector<int> failed_indices;
        for (int i = 0; i < n - 1; ++i) {
            if ((int128)a[i + 1] * R != (int128)a[i] * P) {
                failed_indices.push_back(i);
            }
        }

        k = -1;
        if (failed_indices.size() == 1) {
            int failed_idx = failed_indices[0];
            k = (failed_idx == 0) ? 0 : n - 1;
        } else if (failed_indices.size() == 2) {
            if (failed_indices[1] == failed_indices[0] + 1) {
                k = failed_indices[0] + 1;
            } else {
                continue;
            }
        } else if (failed_indices.empty() && n >= 2) {
            continue;
        } else {
            continue;
        }

        long long original_ak = a[k];
        long long bk = -1;
        bool possible = false;

        if (k == 0) {
            if (P != 0 && (int128)a[1] * R % P == 0) {
                int128 temp_bk = (int128)a[1] * R / P;
                if (temp_bk >= 1 && temp_bk <= 1000000000000000000LL) {
                    bk = (long long)temp_bk;
                    possible = true;
                }
            } else if (P == 0) {
                if ((int128)a[1] * R == 0) {
                    bk = 1;
                    possible = true;
                }
            }
        } else if (k == n - 1) {
            if (R != 0 && (int128)a[k - 1] * P % R == 0) {
                int128 temp_bk = (int128)a[k - 1] * P / R;
                if (temp_bk >= 1 && temp_bk <= 1000000000000000000LL) {
                    bk = (long long)temp_bk;
                    possible = true;
                }
            } else if (R == 0) {
                if ((int128)a[k - 1] * P == 0) {
                    bk = 1;
                    possible = true;
                }
            }
        } else {
            bool calc_from_left_ok = false;
            long long bk_from_left = -1;
            if (R != 0 && (int128)a[k - 1] * P % R == 0) {
                int128 temp_bk = (int128)a[k - 1] * P / R;
                if (temp_bk >= 1 && temp_bk <= 1000000000000000000LL) {
                    bk_from_left = (long long)temp_bk;
                    calc_from_left_ok = true;
                }
            } else if (R == 0) {
                if ((int128)a[k - 1] * P == 0) {
                    bk_from_left = 1;
                    calc_from_left_ok = true;
                }
            }

            bool calc_from_right_ok = false;
            long long bk_from_right = -1;
            if (P != 0 && (int128)a[k + 1] * R % P == 0) {
                int128 temp_bk = (int128)a[k + 1] * R / P;
                if (temp_bk >= 1 && temp_bk <= 1000000000000000000LL) {
                    bk_from_right = (long long)temp_bk;
                    calc_from_right_ok = true;
                }
            } else if (P == 0) {
                if ((int128)a[k + 1] * R == 0) {
                    bk_from_right = 1;
                    calc_from_right_ok = true;
                }
            }

            if (calc_from_left_ok && calc_from_right_ok) {
                if (bk_from_left == bk_from_right) {
                    bk = bk_from_left;
                    possible = true;
                } else {
                    possible = false;
                }
            } else if (calc_from_left_ok) {
                bk = bk_from_left;
                possible = true;
            } else if (calc_from_right_ok) {
                bk = bk_from_right;
                possible = true;
            }

            if (R == 0 && P == 0 && a[k - 1] == 0 && a[k + 1] == 0) {
                bk = 1;
                possible = true;
            }
        }

        if (possible) {
            if (bk >= 1 && bk <= 1000000000000000000LL) {
                a[k] = bk;
                solution_found = true;
                current_best_a = a;
                break;
            } else {
                a[k] = original_ak;
            }
        } else {
            a[k] = original_ak;
        }
    }

    if (!solution_found) {
        if (n >= 2) {
            k = (n > 1) ? 1 : 0;
            P = 2;
            R = 1;
            long long original_ak = current_best_a[k];
            long long bk = -1;
            if (k == 0) {
                if (P != 0 && (int128)current_best_a[1] * R % P == 0) bk = (long long)((int128)current_best_a[1] * R / P);
            } else {
                if (R != 0 && (int128)current_best_a[k - 1] * P % R == 0) bk = (long long)((int128)current_best_a[k - 1] * P / R);
            }

            if (bk != -1 && bk >= 1 && bk <= 1000000000000000000LL) {
                current_best_a[k] = bk;
            } else {
                if (k > 0 && current_best_a[k - 1] >= 1)
                    current_best_a[k] = current_best_a[k - 1];
                else if (k + 1 < n && current_best_a[k + 1] >= 1)
                    current_best_a[k] = current_best_a[k + 1];
                else
                    current_best_a[k] = 1;
            }
        }
    }

    return current_best_a;
}

int main() {
    std::vector<long long> result = solve();

    for (int i = 0; i < result.size(); ++i) {
        std::cout << result[i] << (i == result.size() - 1 ? "" : " ");
    }
    std::cout << std::endl;

    return 0;
}