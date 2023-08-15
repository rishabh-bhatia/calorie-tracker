package com.rishabh.core.domain

import android.content.SharedPreferences
import com.rishabh.core.domain.model.ActivityLevel
import com.rishabh.core.domain.model.Gender
import com.rishabh.core.domain.model.GoalType
import com.rishabh.core.domain.model.UserInfo
import com.rishabh.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPreference: SharedPreferences
) : Preferences {
    override fun saveGender(gender: Gender) {
        sharedPreference.edit().putString(Preferences.KEY_GENDER, gender.name).apply()
    }

    override fun saveAge(age: Int) {
        sharedPreference.edit().putInt(Preferences.KEY_AGE, age).apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPreference.edit().putFloat(Preferences.KEY_WEIGHT, weight).apply()
    }

    override fun saveHeight(height: Int) {
        sharedPreference.edit().putInt(Preferences.KEY_HEIGHT, height).apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        sharedPreference.edit().putString(Preferences.KEY_ACTIVITY_LEVEL, level.name).apply()
    }

    override fun saveGoalType(goalType: GoalType) {
        sharedPreference.edit().putString(Preferences.KEY_GOAL_TYPE, goalType.name).apply()
    }

    override fun saveCarbRatio(carbRatio: Float) {
        sharedPreference.edit().putFloat(Preferences.KEY_CARB_RATIO, carbRatio).apply()
    }

    override fun saveProteinRatio(proteinRatio: Float) {
        sharedPreference.edit().putFloat(Preferences.KEY_PROTEIN_RATIO, proteinRatio).apply()
    }

    override fun saveFatRatio(fatRatio: Float) {
        sharedPreference.edit().putFloat(Preferences.KEY_FAT_RATIO, fatRatio).apply()
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharedPreference.getInt(Preferences.KEY_AGE, -1)
        val height = sharedPreference.getInt(Preferences.KEY_HEIGHT, -1)
        val weight = sharedPreference.getFloat(Preferences.KEY_WEIGHT, -1f)
        val genderString = sharedPreference.getString(Preferences.KEY_GENDER, null)
        val activityLevelString = sharedPreference.getString(Preferences.KEY_ACTIVITY_LEVEL, null)
        val goalType = sharedPreference.getString(Preferences.KEY_GOAL_TYPE, null)
        val carbRatio = sharedPreference.getFloat(Preferences.KEY_CARB_RATIO, -1f)
        val proteinRatio = sharedPreference.getFloat(Preferences.KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharedPreference.getFloat(Preferences.KEY_FAT_RATIO, -1f)

        return UserInfo(
            gender = Gender.fromString(genderString ?: "male"),
            age = age,
            weight = weight,
            height = height,
            activityLevel = ActivityLevel.fromString(activityLevelString ?: "medium"),
            goalType = GoalType.fromString(goalType ?: "keep_weight"),
            carbRatio = carbRatio,
            fatRatio = fatRatio,
            proteinRatio = proteinRatio
        )
    }
}